package com.hscrm.service;

import com.hscrm.domain.Track;
import com.hscrm.domain.TrackVo;

import java.util.List;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/22 14:55
 */
public interface TrackService {
    /**
     * 添加意向
     */
    int addTrack(Track track);

    /**
     * 删除意向
     */
    int deleteTrack(int tid);

    /**
     * 修改意向
     */
    int updateTrack(Track track);

    /**
     * 查询所有意向
     */
    List<TrackVo> findAllTrack();

    /**
     * 通过tid查询单个意向
     */
    Track findOneTrack(int tid);

}
