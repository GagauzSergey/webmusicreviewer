package com.musicreview.service;

import com.musicreview.model.RecordLabel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 04.11.2017.
 */

@Service
public class RecordLabelServiceImpl implements RecordLabelService{

    @Override
    public RecordLabel getRecordLabelByName(String label_name) {
        return null;
    }

    @Override
    public boolean existsRecordLabelByName(String label_name) {
        return false;
    }

    @Override
    public void addRecordLabel(RecordLabel recordLabel) {

    }

    @Override
    public void updateArtist(RecordLabel recordLabel) {

    }

    @Override
    public void deleteArtist(Long id) {

    }

    @Override
    public List<RecordLabel> recordLabelList() {
        return null;
    }
}
