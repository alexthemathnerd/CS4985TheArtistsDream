package edu.westga.devops.theartistsdreamclient.viewmodel;


public class HeaderViewModel {
    private ObservableList<User> users;
    

    public HeaderViewModel() {
        this.users = new ObservableList<User>();
    }

    public ObservableList<User> searchForUsers(String username) {
        ObserverableList<User> searchedUsers = FXCollections.observableList(UserManager.userManager.searchForUsers(username));
        return searchedUsers;
    }
}


