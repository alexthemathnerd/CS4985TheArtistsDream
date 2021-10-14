package edu.westga.devops.theartistsdreamserver.model;

import com.google.gson.internal.LinkedTreeMap;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.utils.UI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class ArtworkManager {

    /**
     * Gets the first fifty artworks
     *
     * @return a request for the first 50 artworks
     * 
     * @param data the objects data
     * 
     * @precondition data != null
     * @postcondition none
     */
    public static Request getFirstFiftyArtworks(Object[] data) {
        TheArtistsDreamServer.LOGGER.info(Arrays.toString(data));
        if (data.length == 1) {
            int userId;
            try {
                userId = ((Double) data[0]).intValue();
                return getFirstFiftyArtworks(userId);
            } catch (ClassCastException e) {
                return new Request(UI.ErrorMessages.INVALID_FORMAT);
            }
        }

	    if (data.length == 2) {
		    int userId;
		    boolean isFollowing;
		    try {
			    userId = ((Double) data[0]).intValue();
			    isFollowing = (Boolean) data[1];
			    return getFirstFiftyArtworks(userId, isFollowing);
		    } catch (ClassCastException e) {
			    return new Request(UI.ErrorMessages.INVALID_FORMAT);
		    }
	    }
        if (TheArtistsDreamServer.ARTWORKS.size() < 50) {
            return new Request(TheArtistsDreamServer.ARTWORKS);
        }
        return new Request(TheArtistsDreamServer.ARTWORKS.subList(0, 50));
    }

    private static Request getFirstFiftyArtworks(int userId) {
        List<Artwork> artworks = new ArrayList<>();
        for (Artwork aArtwork: TheArtistsDreamServer.ARTWORKS) {
            if (aArtwork.getArtistID() == userId) {
                artworks.add(aArtwork);
            }
        }
        if (artworks.size() < 50) {
            return new Request(artworks);
        }
        return new Request(artworks.subList(0, 50));
    }

    private static Request getFirstFiftyArtworks(int userId, boolean isFollowing) {
	    List<Artwork> artworks = new ArrayList<Artwork>();
	    for (Artwork aArtwork : TheArtistsDreamServer.ARTWORKS) {
		    if (aArtwork.getArtistID() == userId && isFollowing) {
			    artworks.add(aArtwork);
		    }
	    }
	    if (artworks.size() < 50) {
		    return new Request(artworks);
	    }
	    return new Request(artworks.subList(0, 50));
    }

    /**
     * Gets the next ten artworks
     *
     * @return a request for the next 10 artworks
     * 
     * @precondition data != null
     * @postcondition none
     * 
     * @param data the objects data
     */
    public static Request getNextTenArtworks(Object[] data) {
        if (data.length == 2) {
            int startingIndex;
            int userId;
            try {
                startingIndex = ((Double) data[0]).intValue();
                userId = ((Double) data[0]).intValue();
                return getNextTenArtworks(startingIndex, userId);
            } catch (ClassCastException e) {
                return new Request(UI.ErrorMessages.INVALID_FORMAT);
            }
        }
        int startingIndex;
        try {
            startingIndex = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        if (startingIndex + 10 > TheArtistsDreamServer.ARTWORKS.size()) {
            return new Request(TheArtistsDreamServer.ARTWORKS);
        }
        return new Request(TheArtistsDreamServer.ARTWORKS.subList(startingIndex, startingIndex + 10));

    }

    private static Request getNextTenArtworks(int startingIndex, int userId) {
        List<Artwork> artworks = new ArrayList<>();
        for (Artwork aArtwork: TheArtistsDreamServer.ARTWORKS) {
            if (aArtwork.getArtistID() == userId) {
                artworks.add(aArtwork);
            }
        }
        if (artworks.size() < startingIndex + 10) {
            return new Request(artworks);
        }
        return new Request(TheArtistsDreamServer.ARTWORKS.subList(startingIndex, startingIndex + 10));
    }

    /**
     * Gets the artwork specified by the data
     *
     * @return a request for the artwork to get
     * 
     * @precondition data != null
     * @postcondition none
     * 
     * @param data the objects data
     */
    public static Request getArtwork(Object[] data) {
        int id;
        try {
            id = (Integer) data[0];
	    for (Artwork artwork : TheArtistsDreamServer.ARTWORKS) {
                if (artwork.getID() == id) {
                    return new Request(artwork);
                }
	    }
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        return new Request(UI.ErrorMessages.ARTWORK_NOT_FOUND);
    }

    /**
     * Adds the artwork specified by the data
     *
     * @return a request to add the artwork
     * 
     * @precondition data != null
     * @postcondition none
     * 
     * @param data the objects data
     */
    public static Request addArtwork(Object[] data) {
        byte[] imageBytes;
        String title;
        int artistID;
        List<Integer> tagIDs;
        String date;
        try {
            ArrayList<Double> bytes = (ArrayList<Double>) data[0];
            imageBytes = new byte[bytes.size()];
            int count = 0;
            for (Double aDouble: bytes) {
                imageBytes[count] = aDouble.byteValue();
                count++;
            }
            title = (String) data[1];
            artistID = ((Double) data[2]).intValue();
            tagIDs = (List<Integer>) data[3];
            date = (String) data[4];
        } catch (ClassCastException e) {
            return new Request(e.getMessage());
        }
        Artwork newArtwork = new Artwork(imageBytes, title, artistID, tagIDs, TheArtistsDreamServer.ARTWORKS.size(), date);
        boolean isAdded = TheArtistsDreamServer.ARTWORKS.add(newArtwork);
        Collections.sort(TheArtistsDreamServer.ARTWORKS);
        return new Request(isAdded);
    }

    /**
     * Removes the artwork specified by the data
     *
     * @return a request to remove the artwork
     * 
     * @precondition data != null
     * @postcondition none
     * 
     * @param data the objects data
     */
    public static Request removeArtwork(Object[] data) {
        int id;
        try {
            id = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        Request artworkRequest = getArtwork(new Object[]{id});

        if (artworkRequest.getError() != null) {
            return new Request(artworkRequest.getError());
        }

        Artwork artworkToRemove = (Artwork) artworkRequest.getData();

        return new Request(TheArtistsDreamServer.ARTWORKS.remove(artworkToRemove));
    }

    /**
     * Edits the artwork specified by the data
     *
     * @return a request to edit the artwork
     * 
     * @precondition data != null
     * @postcondition none
     * 
     * @param data the objects data
     */
    public static Request editArtwork(Object[] data) {
        int id;
        String newTitle;
        List<Integer> newTagIDs;

        try {
            id = ((Double) data[0]).intValue();
            newTitle = (String) data[1];
            newTagIDs = (List<Integer>) data[2];
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        Request artworkRequest = getArtwork(new Object[]{id});

        if (artworkRequest.getError() != null) {
            return new Request(artworkRequest.getError());

        }
        Artwork artworkToEdit = (Artwork) artworkRequest.getData();
	
	if (artworkToEdit == null) {
	    return new Request(false);
	}

        artworkToEdit.setTags(new Object[]{newTagIDs});
        artworkToEdit.setTitle(new Object[]{newTitle});

        return new Request(true);
    }

    /**
     * Gets the artworks of the followed artists
     *
     * @param data the data
     * @precondition data != null
     * @postcondition none
     *
     * @return a request to get the artworks of the followed artists
     */
    public static Request getFollowingArtworks(Object[] data) {
        int userID;
        try {
            userID = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        return new Request(new ArrayList<Artwork>());
    }

    /**
     * Gets the artworks of the artists specified by the data
     *
     * @param data the data specifying the artist
     *
     * @precondition data != null
     * @postcondition none
     *
     * @return a request to get the artworks of the artist specified by the data
     */
    public static Request getArtworksOfArtist(Object[] data) {
        int userID;
        try {
            userID = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        List<Artwork> userArtworks = new ArrayList<Artwork>();

        for (Artwork artwork : TheArtistsDreamServer.ARTWORKS) {
            if (artwork.getArtistID() == userID) {
                userArtworks.add(artwork);
            }
        }
        return new Request(userArtworks);
    }

    /**
     * Gets the artworks of the tags specified by the data
     *
     * @param data the data specifying the tags
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to get the artworks of the tags specified by the data
     */
    public static Request getArtworksOfTags(Object[] data) {
        List tags;
        try {
            tags = (ArrayList) data[0];
            System.out.println(tags.getClass());
        } catch (Exception e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }

        List<Artwork> tagArtworks = new ArrayList<>();
        for (Artwork aArtwork: TheArtistsDreamServer.ARTWORKS) {
            for (Object aTag: tags) {

                LinkedTreeMap<String, Object> tag = (LinkedTreeMap<String, Object>) aTag;
                if (aArtwork.getTagIDs().contains(((Double) tag.get("id")).intValue())) {
                    tagArtworks.add(aArtwork);
                    break;
                }
            }
        }
        return new Request(tagArtworks);
    }

    /**
     * Gets the artworks with titles containing the searchterm specified by the data
     *
     * @param data the data specifying the searchTerm
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to get the artworks with titles conatining the searchterm specified by the data
     */
    public static Request searchForArtworks(Object[] data) {
        String searchTerm;
        try {
            searchTerm = (String) data[0];
        } catch (Exception e) {
            return new Request(UI.ErrorMessages.INVALID_FORMAT);
        }
        List<Artwork> searchedArtworks = new ArrayList<>();
        for (Artwork aArtwork: TheArtistsDreamServer.ARTWORKS) {
            if (aArtwork.getTitle().contains(searchTerm)) {
                searchedArtworks.add(aArtwork);
            }
        }
        return new Request(searchedArtworks);
    }

    /**
     * Gets the artwork with a title matching the title specified by the data
     *
     * @param data the data specifying the title
     *
     * @precondition none
     * @postcondition none
     *
     * @return a request to get the artwork with a title matching the title specified by the data
     */
    public static Request retrieveSearchedArtwork(Object[] data) {
        String title;
        try {
            title = (String) data[0];
        } catch (Exception e) {
            return new Request("Invalid Format");
        }
        for (Artwork aArtwork: TheArtistsDreamServer.ARTWORKS) {
            if (aArtwork.getTitle().equals(title)) {
                return new Request(aArtwork);
            }
        }
        return new Request(null);
    }

}
