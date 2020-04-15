package music.mission2.Controller;

import music.mission2.Model.MusicStore;
import music.mission2.Service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {
    @Autowired
    private MusicService musicSer;

    @GetMapping("/api/music")
    public List<MusicStore> allMusics(){
        return musicSer.getAllmusicList();
    }

    @GetMapping("/api/music/{id}")
    public MusicStore getMusicById(@PathVariable("id") String id) {
        return musicSer.getOneMusic(id);
    }

    @PostMapping("/api/music")
    public void addMusic(@RequestBody MusicStore musicStoreModel) {
        musicSer.addMusic(musicStoreModel);
    }

    @PutMapping("/api/music/{id}")
    public void updateMusic(@RequestBody MusicStore musicStoreModel, @PathVariable("id") String id) {
        musicSer.updateMusic(musicStoreModel, id);
    }

    @DeleteMapping("/api/music/{id}")
    public void removeMusic(@PathVariable("id") String id) {
        musicSer.removeMusic(id);

    }
}
