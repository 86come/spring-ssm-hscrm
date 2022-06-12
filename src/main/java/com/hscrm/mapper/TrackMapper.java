package com.hscrm.mapper;

import com.hscrm.domain.Customer;
import com.hscrm.domain.Track;

import java.util.List;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/22 14:44
 */
public interface TrackMapper {
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
    List<Track> findAllTrack();

    /**
     * 通过tid查询单个意向
     */
    Track findOneTrack(int tid);

}
