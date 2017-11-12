package com.musicreview.service;

import com.musicreview.model.RecordLabel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gagauz Sergey
 * Created by user on 04.11.2017.
 */

public interface RecordLabelService {
        RecordLabel getRecordLabelByName(String label_name);
        boolean existsRecordLabelByName(String label_name);
        void addRecordLabel(RecordLabel recordLabel);
        void updateRecordLabel(RecordLabel recordLabel);
        void deleteRecordLabel (Long id);
        List<RecordLabel> recordLabelList();
}
