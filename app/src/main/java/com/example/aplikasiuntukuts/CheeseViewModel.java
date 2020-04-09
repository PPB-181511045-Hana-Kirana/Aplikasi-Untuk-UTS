package com.example.aplikasiuntukuts;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasiuntukuts.data.Cheese;

import java.util.List;

public class CheeseViewModel extends AndroidViewModel {

    private CheeseRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Cheese>> mAllWords;

    public CheeseViewModel(Application application) {
        super(application);
        mRepository = new CheeseRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Cheese>> getAllWords() {
        return mAllWords;
    }

    void insert(Cheese cheese) {
        mRepository.insert(cheese);
    }
}
