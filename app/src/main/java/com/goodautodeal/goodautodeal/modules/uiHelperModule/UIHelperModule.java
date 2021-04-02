package com.goodautodeal.goodautodeal.modules.uiHelperModule;


import com.goodautodeal.goodautodeal.helpers.UIHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIHelperModule {

    @Singleton
    @Provides
    UIHelper providesUIHelper() {
        return new UIHelper();
    }

}
