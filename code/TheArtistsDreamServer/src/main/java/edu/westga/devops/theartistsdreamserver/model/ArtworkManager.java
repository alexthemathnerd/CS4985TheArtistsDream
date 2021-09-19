package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.model.Artwork;
import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;

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
                return new Request("Invalid Format");
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

    /**
     * Gets the next ten artworks
     *
     * @return a request for the next 10 artworks
     * @precondition data != null
     * @postcondition none
     */
    public static Request getNextTenArtworks(Object[] data) {
        int startingIndex;
        try {
            startingIndex = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }
        if (startingIndex + 10 > TheArtistsDreamServer.ARTWORKS.size()) {
            return new Request(TheArtistsDreamServer.ARTWORKS);
        }
        return new Request(TheArtistsDreamServer.ARTWORKS.subList(startingIndex, startingIndex + 10));

    }

    /**
     * Gets the artwork specified by the data
     *
     * @return a request for the artwork to get
     * @precondition data != null
     * @postcondition none
     */
    public static Request getArtwork(Object[] data) {
        int id;
        try {
            id = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }
        for (Artwork artwork : TheArtistsDreamServer.ARTWORKS) {
            if (artwork.getID() == id) {
                return new Request(artwork);
            }
        }
        return new Request("Artwork not found");
    }

    /**
     * Adds the artwork specified by the data
     *
     * @return a request to add the artwork
     * @precondition data != null
     * @postcondition none
     */
    public static Request addArtwork(Object[] data) {
        byte[] imageBytes;
        String title;
        int artistID;
        List<Integer> tagIDs;
        int id;
        String date;
        try {
            imageBytes = (byte[]) data[0];
            title = (String) data[1];
            artistID = ((Double) data[2]).intValue();
            tagIDs = (List<Integer>) data[3];
            id = ((Double) data[4]).intValue();
            date = (String) data[5];
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }
        Artwork newArtwork = new Artwork(imageBytes, title, artistID, tagIDs, id, date);
        return new Request(TheArtistsDreamServer.ARTWORKS.add(newArtwork));
    }

    /**
     * Removes the artwork specified by the data
     *
     * @return a request to remove the artwork
     * @precondition data != null
     * @postcondition none
     */
    public static Request removeArtwork(Object[] data) {
        int id;
        try {
            id = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }

        Request artworkRequest = getArtwork(new Object[]{id});

        if (artworkRequest.getError() == null) {
            return new Request(artworkRequest.getError());
        }
        Artwork artworkToRemove = (Artwork) artworkRequest.getData();

        return new Request(TheArtistsDreamServer.ARTWORKS.remove(artworkToRemove));
    }

    /**
     * Edits the artwork specified by the data
     *
     * @return a request to edit the artwork
     * @precondition data != null
     * @postcondition none
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
            return new Request("Invalid Format");
        }

        Request artworkRequest = getArtwork(new Object[]{id});
        if (artworkRequest.getError() == null) {
            return new Request(artworkRequest.getError());

        }
        Artwork artworkToEdit = (Artwork) artworkRequest.getData();


//		Artwork artworkToEdit = getArtwork(new Object[] {id}).getData();
        artworkToEdit.setTags(new Object[]{newTagIDs});
        artworkToEdit.setTitle(new Object[]{newTitle});

        return new Request(true);
    }

    /**
     * Gets the artworks of the followed artists
     *
     * @return a request to get the artworks of the followed artists
     * @precondition data != null
     * @postcondition none
     */
    public static Request getFollowingArtworks(Object[] data) {
        int userID;
        try {
            userID = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }

        return new Request(new ArrayList<Artwork>());
    }

    /**
     * Gets the artworks of the artists specified by the data
     *
     * @return a request to get the artworks of the specified artist
     * @precondition data != null
     * @postcondition none
     */
    public static Request getArtworksOfArtist(Object[] data) {
        int userID;
        try {
            userID = ((Double) data[0]).intValue();
        } catch (ClassCastException e) {
            return new Request("Invalid Format");
        }

        List<Artwork> userArtworks = new ArrayList<Artwork>();

        for (Artwork artwork : TheArtistsDreamServer.ARTWORKS) {
            if (artwork.getArtistID() == userID) {
                userArtworks.add(artwork);
            }
        }
        return new Request(userArtworks);
    }

    public static Request getArtworksOfTags(Object[] data) {
        List<Tag> tags;
        try {
            tags = (List<Tag>) data[0];
        } catch (Exception e) {
            return new Request("Invalid Format");
        }

        List<Artwork> tagArtworks = new ArrayList<>();
        for (Artwork aArtwork: TheArtistsDreamServer.ARTWORKS) {
            for (Tag aTag: tags) {
                if (aArtwork.getTagIDs().contains(aTag.getId())) {
                    tagArtworks.add(aArtwork);
                    break;
                }
            }
        }
        return new Request(tagArtworks);
    }

}
