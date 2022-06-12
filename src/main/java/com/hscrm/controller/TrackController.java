package com.hscrm.controller;

import com.github.pagehelper.PageInfo;
import com.hscrm.domain.Customer;
import com.hscrm.domain.Track;
import com.hscrm.domain.TrackVo;
import com.hscrm.service.TrackService;
import com.hscrm.util.ResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName：
 * Description：
 *
 * @author：坏人曹怼怼
 * @date：2022/2/22 15:00
 */
@RestController
public class TrackController {
    @Autowired
    private TrackService trackService;

    /**
     * 添加意向
     * @param track
     * @return
     */
    @RequestMapping(value = "/tra",method = RequestMethod.POST)
    public ResponseEntity<Integer> addTrack(Track track){
        int i = trackService.addTrack(track);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(i);
        return responseEntity;
    }

    /**
     * 删除意向
     * @param tid
     * @return
     */
    @RequestMapping(value = "/tra/{tid}",method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteTrack(@PathVariable(value = "tid") int tid){
        int i = trackService.deleteTrack(tid);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(i);
        return responseEntity;
    }

    /**
     * 修改意向
     */
    @RequestMapping(value = "/tra",method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateTrack(Track track){
        int i = trackService.updateTrack(track);
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(i);
        return responseEntity;
    }

    /**
     * 查找所有意向
     */
    @RequestMapping(value = "/tra",method = RequestMethod.GET)
    public ResponseEntity<List<TrackVo>> findAllTrack(){
        List<TrackVo> allTrack = trackService.findAllTrack();
        ResponseEntity<List<TrackVo>> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(allTrack);
        return responseEntity;
    }

    /**
     * 查找单个意向
     */
    @RequestMapping(value = "/tra/{tid}",method = RequestMethod.GET)
    public ResponseEntity<Track> findOneTrack(@PathVariable(value = "tid")int tid){
        Track oneTrack = trackService.findOneTrack(tid);
        ResponseEntity<Track> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("OK");
        responseEntity.setData(oneTrack);
        return responseEntity;
    }

}
