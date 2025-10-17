package com.app.inventory.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.model.AuditLog;
import com.app.inventory.repository.AuditLogRepository;

@Service
public class AuditLogService {
	   private final AuditLogRepository repo;

	    public AuditLogService(AuditLogRepository repo) {
	        this.repo = repo;
	    }

	    public void log(String username, String action) {
	        AuditLog a = new AuditLog();
	        a.setUsername(username != null ? username : "anonymous");
	        a.setAction(action);
	        a.setTs(LocalDateTime.now()); // <-- matches entity field "ts"
	        repo.save(a);
	    }

	    /** Returns logs from the last 12 months, newest first. */
	    public List<AuditLog> last12Months() {
	        return repo.findByTsAfterOrderByTsDesc(LocalDateTime.now().minusMonths(12));
	    }
}