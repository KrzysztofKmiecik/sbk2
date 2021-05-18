package pl.kmiecik.sbk2.RestVideoApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    List<Video> videoList;


    public VideoApi(List<Video> videoList) {
        this.videoList = videoList;
        videoList.add(new Video(1L, "Ogniem i mieczem ", "http://wp.pl"));
        videoList.add(new Video(2L, "Pan Wolodyjowski", "http://interia.pl"));

    }

    @GetMapping
    public ResponseEntity<List<Video>> getvideos() {
        return new ResponseEntity<List<Video>>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        Optional<Video> myVideo = videoList.stream().filter(video -> video.id == id).findFirst();

        if (myVideo.isPresent()) {
            return new ResponseEntity<Video>(myVideo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Object> addVideo(@RequestBody Video video) {
        boolean addResult = videoList.add(video);
        if (addResult) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeVideo(@PathVariable Long id) {
        Optional<Video> myVideo = videoList.stream().filter(video -> video.id == id).findFirst();
        if (myVideo.isPresent()) {
            videoList.remove(myVideo.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Optional<Video>> updateVideo(@RequestBody Video newVideo) {
        Optional<Video> myVideo = videoList.stream().filter(video -> video.id == newVideo.getId()).findFirst();
        if (myVideo.isPresent()) {
            videoList.remove(myVideo.get());
            videoList.add(newVideo);
            return ResponseEntity.ok(myVideo);
        }
        return ResponseEntity.notFound().build();
    }
}
