package com.plt.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	public String generateUniqueId() {
		return UUID.randomUUID().toString();
	}
}
