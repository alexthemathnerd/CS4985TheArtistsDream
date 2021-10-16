public class Messager {
    
    public Messager() {

    }

    public String sendMessage(String message, User sender, User reciever) {
        Type type = new TypeToken<Response<String>>() {
        }.getType();
        Response<String> response = this.communicator.request(new Request(UI.ServerCodes.sendMessage, new Object[]{message, sender, reciever}), type);
        if (response.getError() != null) {
            TheArtistsDreamApplication.LOGGER.warning(response.getError());
            return null;
        }
        return response.getData();
    }
}
