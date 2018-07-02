package vn.neolab.versioncontrolmvvm.ui.main.version;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vn.neolab.versioncontrolmvvm.BR;
import vn.neolab.versioncontrolmvvm.R;
import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;
import vn.neolab.versioncontrolmvvm.databinding.FragmentVersionBinding;
import vn.neolab.versioncontrolmvvm.ui.base.BaseFragment;
import vn.neolab.versioncontrolmvvm.ui.main.detail.DetailFragment;
import vn.neolab.versioncontrolmvvm.utils.FragmentUtils;

public class VersionFragment extends BaseFragment<FragmentVersionBinding, VersionViewModel>
        implements VersionNavigator, VersionAdapter.VersionAdapterListener,
        SwipeRefreshLayout.OnRefreshListener {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @Inject
    VersionAdapter mVersionAdapter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;

    FragmentVersionBinding mFragmentVersionBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_version;
    }

    @Override
    public VersionViewModel getViewModel() {
        return ViewModelProviders.of(this, mViewModelFactory)
                .get(VersionViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentVersionBinding = getViewDataBinding();
        setup();
        subscribeToLiveData();

    }

    private void subscribeToLiveData() {
        getViewModel().getVersionListLiveData().observe(this, list -> {
            Toast.makeText(getContext(), "Get version success", Toast.LENGTH_SHORT).show();
            mFragmentVersionBinding.swipeRl.setRefreshing(false);
            getViewModel().addVersionItemToList(list);
        });
    }

    private void setup() {
        mVersionAdapter.setListener(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView rv = mFragmentVersionBinding.rvVersion;
        rv.setLayoutManager(mLinearLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(mVersionAdapter);

        SwipeRefreshLayout srl = mFragmentVersionBinding.swipeRl;
        srl.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        srl.setOnRefreshListener(this);

    }

    @Override
    public void handleError(Throwable throwable) {
        VersionResponse.Version version = new VersionResponse.Version(1, "dev",
                "aasd", "asdasd", "asdasd", "1", "2.3",
                1, 2, "2 thang 9", "ahihi");

        List<VersionResponse.Version> list = new ArrayList<>();
        list.add(version);
        getViewModel().addVersionItemToList(list);

        Toast.makeText(getContext(), throwable.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(VersionResponse.Version version) {
        Bundle args = new Bundle();
        args.putSerializable(DetailFragment.VERSION, version);
        FragmentUtils.replaceFragmentInFragment(DetailFragment.class, this, R.id.child_container,
                true, args);
    }

    @Override
    public void onRefresh() {
        getViewModel().fetchVersion();
    }
}
