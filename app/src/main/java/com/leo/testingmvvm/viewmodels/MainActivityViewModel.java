package com.leo.testingmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.leo.testingmvvm.models.NicePlace;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<NicePlace>> mNicePlaces;

    public  void  init(){
        //mNicePlaces.postValue();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return  mNicePlaces;
    }
}
