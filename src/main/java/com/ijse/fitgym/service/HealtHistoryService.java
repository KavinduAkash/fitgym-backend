package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.HealthHistoryDTO;
import com.ijse.fitgym.dto.json.request.HealthQuetionSaveRequestDTO;

import java.util.List;

public interface HealtHistoryService {
    List<HealthHistoryDTO> saveNewHealthQuetion(HealthQuetionSaveRequestDTO dto);
    List<HealthHistoryDTO> updateHealthQuetion(HealthHistoryDTO dto);
    List<HealthHistoryDTO> getAllHealthHistoryQuestion();
    List<HealthHistoryDTO> getAllActiveHealthHistoryQuestion();
    List<HealthHistoryDTO> activeChange(long id);
}
