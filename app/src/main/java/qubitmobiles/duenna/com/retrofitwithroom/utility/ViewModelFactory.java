package qubitmobiles.duenna.com.retrofitwithroom.utility;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import qubitmobiles.duenna.com.retrofitwithroom.activity.MainActivityViewModel;
import qubitmobiles.duenna.com.retrofitwithroom.fragment.TestFragmentViewModel;
import qubitmobiles.duenna.com.retrofitwithroom.repository.Repository;

public class ViewModelFactory implements ViewModelProvider.Factory {
    public final Repository repository;

    @Inject
    public ViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(repository);
        }
        else if(modelClass.isAssignableFrom(TestFragmentViewModel.class)) {
            return (T) new TestFragmentViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}


// Switch case :
