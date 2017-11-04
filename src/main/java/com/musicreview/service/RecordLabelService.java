package com.musicreview.service;

import com.musicreview.model.RecordLabel;

import java.util.List;

/**
 * Created by user on 04.11.2017.
 */
public interface RecordLabelService {
        RecordLabel getRecordLabelByName(String label_name);
        boolean existsRecordLabelByName(String label_name);
        void addRecordLabel(RecordLabel recordLabel);
        void updateArtist(RecordLabel recordLabel);
        void deleteArtist (Long id);
        List<RecordLabel> recordLabelList();
}
