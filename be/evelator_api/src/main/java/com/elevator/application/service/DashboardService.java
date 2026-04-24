package com.elevator.application.service;

import com.elevator.domain.repository.ContactRequestRepository;
import com.elevator.domain.repository.DocumentRepository;
import com.elevator.domain.repository.PostRepository;
import com.elevator.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ProductRepository productRepository;
    private final PostRepository postRepository;
    private final DocumentRepository documentRepository;
    private final ContactRequestRepository contactRequestRepository;

    public Map<String, Long> getStatistics() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalProducts", productRepository.count());
        stats.put("totalPosts", postRepository.count());
        stats.put("totalDocuments", documentRepository.count());
        stats.put("newContacts", contactRequestRepository.countByStatus("NEW"));
        return stats;
    }
}
