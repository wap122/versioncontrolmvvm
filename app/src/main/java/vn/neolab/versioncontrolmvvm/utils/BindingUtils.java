package vn.neolab.versioncontrolmvvm.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.neolab.versioncontrolmvvm.data.model.api.VersionResponse;
import vn.neolab.versioncontrolmvvm.ui.main.version.VersionAdapter;

public class BindingUtils {

    @BindingAdapter({"adapter"})
    public static void addVersionItems(RecyclerView recyclerView, List<VersionResponse.Version> list) {
        VersionAdapter adapter = (VersionAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(list);
        }
    }

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, Integer id) {
        Context context = imageView.getContext();
        Glide.with(context).load(id).into(imageView);
    }

//    @BindingAdapter({"visibility"})
//    public static void setVisibility(ImageButton imageButton, boolean isShow) {
//        if (isShow) imageButton.setVisibility(View.VISIBLE);
//        else imageButton.setVisibility(View.GONE);
//    }

}
