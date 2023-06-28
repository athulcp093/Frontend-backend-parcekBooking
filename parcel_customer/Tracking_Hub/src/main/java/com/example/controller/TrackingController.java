package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ParcelDTO;
import com.example.dto.TrackingInfoDTO;
//import com.example.dto.TrackingInfoDTO;
import com.example.entity.TrackingInfo;
import com.example.service.TrackingService;
import com.example.util.Demoparcel1Interface;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/tracking")
public class TrackingController {
    @Autowired
    TrackingService trackingService;
    @Autowired
    Demoparcel1Interface demoparcel1Interface;
    
    @PostMapping("/add")
    public ResponseEntity<TrackingInfoDTO> addTrackingInfo(@RequestBody TrackingInfoDTO trackingInfoDTO) {
    	// Convert TrackingInfoDTO to TrackingInfo entity
    	TrackingInfo trackingInfo= new TrackingInfo();
         trackingInfo.setId(trackingInfoDTO.getId());
    	trackingInfo.setParcelId(trackingInfoDTO.getParcelId());
    	trackingInfo.setCurrentStatus(trackingInfoDTO.getCurrentStatus());
    	trackingInfo.setLocation(trackingInfoDTO.getLocation());
    	
    	// Call the service method to save the entity
        TrackingInfo savedTrackingInfo = trackingService.addTrackingInfo(trackingInfo);
        
     // Convert the saved entity back to TrackingInfoDTO
        TrackingInfoDTO savedTrackingInfoDTO = new TrackingInfoDTO();
        savedTrackingInfoDTO.setId(savedTrackingInfo.getId());
        savedTrackingInfoDTO.setParcelId(savedTrackingInfo.getParcelId());
        savedTrackingInfoDTO.setCurrentStatus(savedTrackingInfo.getCurrentStatus());
        savedTrackingInfoDTO.setLocation(savedTrackingInfo.getLocation());


    	return ResponseEntity.ok().body(savedTrackingInfoDTO);
    }

    @GetMapping("/getID/{id}")
    public ResponseEntity<TrackingInfoDTO> getTrackingInfoById(@PathVariable Long id) {
    	TrackingInfoDTO trackingInfoDTO = new TrackingInfoDTO();
    	final var trackingInfo = trackingService.getTrackingInfo(id).get();
    	trackingInfoDTO.setId(trackingInfo.getId());
    	System.out.println(trackingInfo.getId());
    	trackingInfoDTO.setParcelId(trackingInfo.getParcelId());
    	System.out.println(trackingInfo.getParcelId());
    	trackingInfoDTO.setCurrentStatus(trackingInfo.getCurrentStatus());
    	System.out.println(trackingInfo.getCurrentStatus());
    	trackingInfoDTO.setLocation(trackingInfo.getLocation());
    	System.out.println(trackingInfo.getLocation());
       
        return ResponseEntity.ok().body(trackingInfoDTO);
    }
    @GetMapping("/getByParcelId/{id}")
    public ResponseEntity<TrackingInfoDTO> getTrackingInfoByParcelID(@PathVariable Long id){
    	
    	TrackingInfoDTO trackingInfoDTO = new TrackingInfoDTO();
    	final var trackingInfo = trackingService.getTrackingInfoByParcelId(id).get();
    	trackingInfoDTO.setId(trackingInfo.getId());
    	System.out.println(trackingInfo.getId());
    	trackingInfoDTO.setParcelId(trackingInfo.getParcelId());
    	System.out.println(trackingInfo.getParcelId());
    	trackingInfoDTO.setCurrentStatus(trackingInfo.getCurrentStatus());
    	System.out.println(trackingInfo.getCurrentStatus());
    	trackingInfoDTO.setLocation(trackingInfo.getLocation());
    	System.out.println(trackingInfo.getLocation());
    	
    	return ResponseEntity.ok().body(trackingInfoDTO);
    }
    @GetMapping("parcels")
    public ResponseEntity<?> getparcels(){
    	return ResponseEntity.ok().body(trackingService.getallParcels());
    }

    // Other endpoints and methods as needed
}
