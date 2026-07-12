package com.techspine.diamond.service;

import com.techspine.diamond.entity.Stone;
import com.techspine.diamond.projection.StoneProjection;
import com.techspine.diamond.repository.*;
import com.techspine.diamond.request.StoneListRequest;
import com.techspine.diamond.request.StoneRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.StoneDataListResponse;
import com.techspine.diamond.response.StoneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoneService {

    private final ShapeRepository shapeRepository;
    private final ColorRepository colorRepository;
    private final ClarityRepository clarityRepository;
    private final CutRepository cutRepository;
    private final PolishRepository polishRepository;
    private final SymmetryRepository symmetryRepository;
    private final FluorescenceRepository fluorescenceRepository;
    private final LabRepository labRepository;
    private final PaymentStatusRepository paymentStatusRepository;
    private final LocationRepository locationRepository;
    private final TermsRepository termsRepository;
    private final StoneRepository stoneRepository;

    @Autowired
    public StoneService(ShapeRepository shapeRepository, ColorRepository colorRepository, ClarityRepository clarityRepository, CutRepository cutRepository, PolishRepository polishRepository, SymmetryRepository symmetryRepository, FluorescenceRepository fluorescenceRepository, LabRepository labRepository, PaymentStatusRepository paymentStatusRepository, LocationRepository locationRepository, TermsRepository termsRepository, StoneRepository stoneRepository) {
        this.shapeRepository = shapeRepository;
        this.colorRepository = colorRepository;
        this.clarityRepository = clarityRepository;
        this.cutRepository = cutRepository;
        this.polishRepository = polishRepository;
        this.symmetryRepository = symmetryRepository;
        this.fluorescenceRepository = fluorescenceRepository;
        this.labRepository = labRepository;
        this.paymentStatusRepository = paymentStatusRepository;
        this.locationRepository = locationRepository;
        this.termsRepository = termsRepository;
        this.stoneRepository = stoneRepository;
    }

    // CREATE
    public ApiResponse<String> createStone(StoneRequest request) {

        Stone stone = new Stone();

        // Identity
        stone.setKapan(request.getKapan());
        stone.setLotNo(request.getLotNo());
        stone.setWeightCt(request.getWeightCt());

        stone.setShape(shapeRepository.findById(request.getShapeId()).orElseThrow(() -> new RuntimeException("Shape not found")));

        // Grading
        stone.setColor(colorRepository.findById(request.getColorId()).orElseThrow(() -> new RuntimeException("Color not found")));

        stone.setClarity(clarityRepository.findById(request.getClarityId()).orElseThrow(() -> new RuntimeException("Clarity not found")));

        stone.setCut(cutRepository.findById(request.getCutId()).orElseThrow(() -> new RuntimeException("Cut not found")));

        stone.setPolish(polishRepository.findById(request.getPolishId()).orElseThrow(() -> new RuntimeException("Polish not found")));

        stone.setSymmetry(symmetryRepository.findById(request.getSymmetryId()).orElseThrow(() -> new RuntimeException("Symmetry not found")));

        stone.setFluorescence(fluorescenceRepository.findById(request.getFluorescenceId()).orElseThrow(() -> new RuntimeException("Fluorescence not found")));

        stone.setLab(labRepository.findById(request.getLabId()).orElseThrow(() -> new RuntimeException("Lab not found")));

        stone.setCertNo(request.getCertNo());

        // Pricing
        stone.setPerCarat(request.getPerCarat());
        stone.setTotalCarat(request.getTotalCarat());
        stone.setRate(request.getRate());
        stone.setAmount(request.getAmount());
        stone.setBrokerage(request.getBrokerage());
        stone.setFinalAmount(request.getFinalAmount());

        // Sales
        stone.setPaymentStatus(paymentStatusRepository.findById(request.getPaymentStatusId()).orElseThrow(() -> new RuntimeException("Payment Status not found")));

        stone.setLocation(locationRepository.findById(request.getLocationId()).orElseThrow(() -> new RuntimeException("Location not found")));

        stone.setTerms(termsRepository.findById(request.getTermsId()).orElseThrow(() -> new RuntimeException("Terms not found")));

        stone.setSellDate(request.getSellDate());
        stone.setPaymentDoneDate(request.getPaymentDoneDate());

        stone.setPartyName(request.getPartyName());
        stone.setBrokerName(request.getBrokerName());

        Stone savedStone = stoneRepository.save(stone);

        return new ApiResponse<>(1, "Item added successfully", null);
    }

    // GET ALL
    public ApiResponse<StoneDataListResponse> getAllStones(StoneListRequest request) {
        try {

            Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                    ? Sort.by(request.getSortBy()).ascending()
                    : Sort.by(request.getSortBy()).descending();

            Pageable pageable = PageRequest.of(
                    request.getPageNo(),
                    request.getPageSize(),
                    sort
            );

            Page<StoneProjection> page = stoneRepository.findAllStones(
                    request.getSearch(),

                    request.getShapeId(),
                    request.getColorId(),
                    request.getClarityId(),
                    request.getCutId(),
                    request.getPolishId(),
                    request.getSymmetryId(),
                    request.getFluorescenceId(),
                    request.getLabId(),
                    request.getPaymentStatusId(),
                    request.getLocationId(),
                    request.getTermsId(),

                    request.getFromDate(),
                    request.getToDate(),

                    pageable
            );

            List<StoneResponse> dataList = page.getContent()
                    .stream()
                    .map(StoneResponse::new)
                    .toList();

            StoneDataListResponse response = new StoneDataListResponse(
                    page.getTotalElements(),
                    page.getTotalPages(),
                    page.getNumber(),
                    page.getSize(),
                    dataList
            );

            return new ApiResponse<>(
                    1,
                    "Stones fetched successfully",
                    response
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(
                    0,
                    e.getMessage(),
                    null
            );
        }
    }

    // GET BY ID
    public ApiResponse<StoneResponse> getStoneById(Long id) {

        Stone stone = stoneRepository.findById(id).orElseThrow(() -> new RuntimeException("Stone not found with id : " + id));

        return new ApiResponse<>(1, "Item fetched successfully", new StoneResponse(stone));
    }

    // UPDATE
    public ApiResponse<String> updateStone(Long id, StoneRequest request) {

        Stone stone = stoneRepository.findById(id).orElse(null);

        if (stone == null) {
            return new ApiResponse<>(0, "Stone not found for id = " + id, null);
        }

        // Identity
        stone.setKapan(request.getKapan());
        stone.setLotNo(request.getLotNo());
        stone.setWeightCt(request.getWeightCt());

        stone.setShape(shapeRepository.findById(request.getShapeId()).orElseThrow(() -> new RuntimeException("Shape not found")));

        // Grading
        stone.setColor(colorRepository.findById(request.getColorId()).orElseThrow(() -> new RuntimeException("Color not found")));

        stone.setClarity(clarityRepository.findById(request.getClarityId()).orElseThrow(() -> new RuntimeException("Clarity not found")));

        stone.setCut(cutRepository.findById(request.getCutId()).orElseThrow(() -> new RuntimeException("Cut not found")));

        stone.setPolish(polishRepository.findById(request.getPolishId()).orElseThrow(() -> new RuntimeException("Polish not found")));

        stone.setSymmetry(symmetryRepository.findById(request.getSymmetryId()).orElseThrow(() -> new RuntimeException("Symmetry not found")));

        stone.setFluorescence(fluorescenceRepository.findById(request.getFluorescenceId()).orElseThrow(() -> new RuntimeException("Fluorescence not found")));

        stone.setLab(labRepository.findById(request.getLabId()).orElseThrow(() -> new RuntimeException("Lab not found")));

        stone.setCertNo(request.getCertNo());

        // Pricing
        stone.setPerCarat(request.getPerCarat());
        stone.setTotalCarat(request.getTotalCarat());
        stone.setRate(request.getRate());
        stone.setAmount(request.getAmount());
        stone.setBrokerage(request.getBrokerage());
        stone.setFinalAmount(request.getFinalAmount());

        // Sales
        stone.setPaymentStatus(paymentStatusRepository.findById(request.getPaymentStatusId()).orElseThrow(() -> new RuntimeException("Payment Status not found")));

        stone.setLocation(locationRepository.findById(request.getLocationId()).orElseThrow(() -> new RuntimeException("Location not found")));

        stone.setTerms(termsRepository.findById(request.getTermsId()).orElseThrow(() -> new RuntimeException("Terms not found")));

        stone.setSellDate(request.getSellDate());
        stone.setPaymentDoneDate(request.getPaymentDoneDate());

        stone.setPartyName(request.getPartyName());
        stone.setBrokerName(request.getBrokerName());

        Stone savedStone = stoneRepository.save(stone);

        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    // DELETE
    public ApiResponse<String> deleteStone(Long id) {
        stoneRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}