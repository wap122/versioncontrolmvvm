package vn.neolab.versioncontrolmvvm.ui.main.version;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;
import vn.neolab.versioncontrolmvvm.databinding.ItemVersionViewBinding;
import vn.neolab.versioncontrolmvvm.ui.base.BaseViewHolder;

public class VersionAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final List<VersionResponse.Version> mVersionList;
    private VersionAdapterListener mListener;

    VersionAdapter(List<VersionResponse.Version> mVersionList) {
        this.mVersionList = mVersionList;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemVersionViewBinding binding = ItemVersionViewBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false);

        return new VersionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mVersionList.size();
    }

    public void clearItems() {
        mVersionList.clear();
        notifyDataSetChanged();
    }

    public void addItems(List<VersionResponse.Version> list) {
        mVersionList.addAll(list);
        notifyDataSetChanged();
    }

    public class VersionViewHolder extends BaseViewHolder implements VersionItemViewModel.VersionItemViewModelListener {

        private ItemVersionViewBinding mBinding;

        private VersionItemViewModel mVersionItemViewModel;

        VersionViewHolder(ItemVersionViewBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final VersionResponse.Version version = mVersionList.get(position);
            mVersionItemViewModel = new VersionItemViewModel(version, this);
            mBinding.setViewModel(mVersionItemViewModel);

            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(VersionResponse.Version version) {
            mListener.onItemClick(version);
        }
    }

    interface VersionAdapterListener {
        void onItemClick(VersionResponse.Version version);
    }

    public void setListener(VersionAdapterListener mListener) {
        this.mListener = mListener;
    }
}
