package music.mission2.Service;

import music.mission2.Model.MusicStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MusicService {
    private List<MusicStore> musicList = new ArrayList<>(Arrays.asList(
            new MusicStore("0001","Movie","Tom Misch"),
            new MusicStore("0002","Younger","Keshi"),
            new MusicStore("0003","Congratulations","Eric Nam"),
            new MusicStore("0004","June","Charlie Burg"),
            new MusicStore("0005","Dance","offonoff")
    ));
    public List<MusicStore> getAllmusicList() {
        return musicList;
    }

    public MusicStore getOneMusic(String id) {
        return musicList.stream().filter(music -> music.getId().equals(id)).findFirst().get();
    }
    public void addMusic(MusicStore musicStoreModel) {
        musicList.add(musicStoreModel);
    }

    public void updateMusic(MusicStore musicStoreModel, String id) {
        int counter = 0;
        for (MusicStore musicStoreModel1 : musicList) {
            if (musicStoreModel1.getId().equals(id)) {
                musicList.set(counter, musicStoreModel);
            }
            counter++;
        }
    }

    public void removeMusic(String id) {
        musicList.removeIf(musicStoreModel -> musicStoreModel.getId().equals(id));
    }
}
