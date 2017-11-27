package com.musicreview.service;

import com.musicreview.model.MusicRelease;

import java.util.List;

/**
 * @author Gagauz Sergey
 * Created by user on 11.11.2017.
 */
public interface MusicReleaseService {

    MusicRelease getMusicReleaseByTitle(String release_title);
    boolean existsMusicReleaseByTitle(String release_title);
    void addMusicRelease(MusicRelease musicRelease);
    void updateMusicRelease(MusicRelease musicRelease);
    void deleteMusicRelease (Long id);
    MusicRelease getMusicReleaseById (long id);
    List<MusicRelease> musicReleaseList();
}
