package org.mp.a1022mvvmpracticedatabinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {
    //ViewModel.
    //In this case we're doing LiveData

    public MutableLiveData<UserModel> userModelMutableLiveData;

    //GET method
    public MutableLiveData<UserModel> getUserModelMutableLiveData() {

        //if it's null, load it to get it
        if(userModelMutableLiveData == null)
            userModelMutableLiveData = new MutableLiveData<>();
            loadData();

        return userModelMutableLiveData;
    }

    //load it from userModel
    private void loadData() {
        UserModel userModel = new UserModel("abc@gmail.com", "123456");
        userModelMutableLiveData.setValue(userModel);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
