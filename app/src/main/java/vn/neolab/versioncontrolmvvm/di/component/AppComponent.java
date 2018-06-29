package vn.neolab.versioncontrolmvvm.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import vn.neolab.versioncontrolmvvm.MvvmApp;
import vn.neolab.versioncontrolmvvm.di.builder.ActivityBuilder;
import vn.neolab.versioncontrolmvvm.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
