package com.ctbri.youeryuandaquan.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctbri.youeryuandaquan.MyApplication;
import com.ctbri.youeryuandaquan.R;
import com.ctbri.youeryuandaquan.adapter.AgentAdapter;
import com.ctbri.youeryuandaquan.adapter.BannerAdapter;
import com.ctbri.youeryuandaquan.data.AdData;
import com.ctbri.youeryuandaquan.data.YouErYuanData;
import com.ctbri.youeryuandaquan.net.NetUtil;
import com.ctbri.youeryuandaquan.net.OkHttpClientManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Request;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements FavFragment.OnListFragmentInteractionListener {
    private static final String ARG_PARAM1 = "param1";

    private int category;
    private int offset = 0, count = 10;
    private boolean isVisible = false;

    private BannerAdapter bannerAdapter = new BannerAdapter();
    private AgentAdapter agentAdapter = new AgentAdapter(MainFragment.this);
    private ViewPager viewPager;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param category Parameter 1.
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance(int category) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = (ViewPager) rootView.findViewById(R.id.vp_banner);
        viewPager.setAdapter(bannerAdapter);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        recyclerView.setAdapter(agentAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if (isVisibleToUser) {
            // 相当于Fragment的onResume
            if (bannerAdapter.getCount() == 0)
                getAdData();
            if (agentAdapter.getItemCount() == 0)
                getAgentData(offset, count);
        } else {
            // 相当于Fragment的onPause
        }
    }

    private void getAdData() {
        OkHttpClientManager.getAsyn(NetUtil.getAdvertisingColumn(getContext()), new OkHttpClientManager.ResultCallback<JsonObject>() {
            @Override
            public void onError(Request request, Exception e) {
                //TODO 重试
                e.printStackTrace();
            }

            @Override
            public void onResponse(JsonObject response) {
                List<AdData> datas = new Gson().fromJson(response.getAsJsonArray("data"), new TypeToken<List<AdData>>() {
                }.getType());
                bannerAdapter.add(datas);
                bannerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void getAgentData(int offset, int count) {
        OkHttpClientManager.postAsyn(NetUtil.getByArea(), new OkHttpClientManager.ResultCallback<JsonObject>() {
            @Override
            public void onError(Request request, Exception e) {
                //TODO 重试
                e.printStackTrace();
            }

            @Override
            public void onResponse(JsonObject response) {
                switch (response.get("errorcode").getAsInt()) {
                    case 0:

                        break;
                    case 1:
                        List<YouErYuanData> datas = new Gson().fromJson(response.getAsJsonArray("data"), new TypeToken<List<YouErYuanData>>() {
                        }.getType());
                        agentAdapter.add(datas);
                        agentAdapter.notifyDataSetChanged();
                        break;
                }
            }
        }, NetUtil.getByArea(MyApplication.locationData.level,
                MyApplication.locationData.code, "[all]",
                "all", null, "desc", offset, count));
    }

    @Override
    public void onListFragmentInteraction(YouErYuanData item) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
