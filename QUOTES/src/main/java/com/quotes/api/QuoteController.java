package com.quotes.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

	@Autowired
	private QuoteService qs;

	@GetMapping("/")
	public String quote(Model model) throws IOException, InterruptedException {
		model.addAttribute("quotes", qs.randomAnim());
		model.addAttribute("tenQuotes", qs.tenAnime());
		return "index";
	}
}
