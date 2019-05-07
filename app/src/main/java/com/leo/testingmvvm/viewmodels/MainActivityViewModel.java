package com.leo.testingmvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.leo.testingmvvm.models.NicePlace;
import com.leo.testingmvvm.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public  void  init(){
        //mNicePlaces.postValue();
        if (mNicePlaces != null){
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return  mNicePlaces;
    }

    public void addNewValue(final NicePlace nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(nicePlace);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

}
