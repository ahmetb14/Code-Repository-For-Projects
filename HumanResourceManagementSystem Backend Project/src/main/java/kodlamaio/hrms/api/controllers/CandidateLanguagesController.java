package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("api/candidatelanguages")
@CrossOrigin
public class CandidateLanguagesController {

	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {

		super();
		this.candidateLanguageService = candidateLanguageService;

	}

	@GetMapping("/getall")
	public DataResult<List<CandidateLanguage>> getAll() {

		return this.candidateLanguageService.getAll();

	}

}
