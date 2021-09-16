package edu.westga.devops.theartistsdreamclient.model.network;

import edu.westga.devops.theartistsdreamclient.utils.UI;
import edu.westga.devops.theartistsdreamclient.model.Artwork;
import edu.westga.devops.theartistsdreamclient.model.ArtworkManager;

import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Iterator;

/**
 * Network Implementation of Collection Class ArtworkManager
 *
 * @author Aznella Joseph
 * @version Fall 2021
 */
public class NetworkArtworkManager extends ArtworkManager {


	private Communicator communicator;

	/**
	 * Creates a new NetworkArtworkManager
	 *
	 * @precondition none
	 * @postcondition none
	 */
	public NetworkArtworkManager() {
		this.communicator = new Communicator("tcp://localhost:444");
	}

	@Override
	public List<Artwork> getFirstFiftyArtworks() {
//		Type type = new TypeToken<Response<ArrayList<Artwork>>>(){}.getType();
//		Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_FIRST_FIFTY, new Object[], type));
//
//		if (response.getError() != null) {
//			TheArtistsDreamApplication.LOGGER.warning(response.getError());
//			return new ArrayList<Artwork>();
//		}
//		return response.getData();

		return null;
	}

	@Override
	public List<Artwork> getNextTenArtworks(int startingIndex) {

//		Type type = new TypeToken<Response<ArrayList<Artwork>>>{}.getType();

//		Response<ArrayList<Artwork>> response = this.communicator.request(new Request(UI.ServerCodes.GET_NEXT_TEN_ARTWORKS, new Object[]{startingIndex}));

//		if (response.getError() != null) {
//			TheArtistsDreamApplication.LOGGER.warning(response.getError());
//			return new ArrayList<Artwork>();
//		}


//		return response.getData();
//

		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Artwork getArtwork(int id) {
		return null;
	}

	@Override
	public boolean addArtwork(Artwork artwork) {
		return false;
	}

	@Override
	public boolean removeArtwork(int id) {
		return false;
	}

	@Override
	public boolean editArtwork(int id, String newTitle, List<Integer> newTagIDs) {
		return false;
	}

	@Override
	public List<Artwork> getFollowingArtworks(int userId) {
		return null;
	}

	@Override
	public List<Artwork> getArtworksOfArtist(int userId) {
		return null;
	}

	@Override
	public Iterator iterator(){
		return null;
	}

}
