package com.goodautodeal.goodautodeal.modules.internetModule;


import com.goodautodeal.goodautodeal.helpers.Internet;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InternetModule {

    @Singleton
    @Provides
    Internet providesInternetState(){
        return new Internet();
    }
}
