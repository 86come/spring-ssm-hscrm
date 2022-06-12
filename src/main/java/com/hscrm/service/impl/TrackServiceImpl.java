package com.hscrm.service.impl;

import com.hscrm.domain.Customer;
import com.hscrm.domain.Emp;
import com.hscrm.domain.Track;
import com.hscrm.domain.TrackVo;
import com.hscrm.mapper.CustomerMapper;
import com.hscrm.mapper.EmpMapper;
import com.hscrm.mapper.TrackMapper;
import com.hscrm.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/22 14:56
 */
@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int addTrack(Track track) {
        int i = trackMapper.addTrack(track);
        return i;
    }

    @Override
    public int deleteTrack(int tid) {
        int i = trackMapper.deleteTrack(tid);
        return i;
    }

    @Override
    public int updateTrack(Track track) {
        int i = trackMapper.updateTrack(track);
        return i;
    }

    @Override
    public List<TrackVo> findAllTrack() {
        List<Track> allTrack = trackMapper.findAllTrack();
        List<TrackVo> list = new ArrayList<>();
        for (Track track : allTrack) {
            TrackVo trackVo = new TrackVo();
            Customer customer = customerMapper.findOneCustomer(track.getCid());
            Emp emp = empMapper.findEmpByEid(track.getEid());
            trackVo.setTid(track.getTid());
            trackVo.setCustomer(customer);
            trackVo.setEmp(emp);
            trackVo.setRecord(track.getRecord());
            trackVo.setIntention(track.getIntention());
            list.add(trackVo);
        }
        return list;
    }

    @Override
    public Track findOneTrack(int tid) {
        Track track = trackMapper.findOneTrack(tid);
        return track;
    }
}
