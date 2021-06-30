package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;

import kodlamaio.hrms.entities.concretes.CandidateSchool;
import kodlamaio.hrms.entities.dtos.CandidateSchoolDto;

@RestController
@RequestMapping("/api/candidateschools")
@CrossOrigin
public class CandidateSchoolsController {

	private CandidateSchoolService candidateSchoolService;

	@Autowired
	public CandidateSchoolsController(CandidateSchoolService candidateSchoolService) {

		this.candidateSchoolService = candidateSchoolService;

	}

	@GetMapping("/findbycandidatecvid")
	public DataResult<List<CandidateSchool>> findByCandidateId(@RequestParam int id) {

		return this.candidateSchoolService.findByCandidateId(id);

	}

	@GetMapping("/getbyid")
	public DataResult<List<CandidateSchool>> getbyid(@RequestParam int id) {

		return this.candidateSchoolService.getBySchoolId(id);

	}

	@PostMapping("/update")
	public Result update(@RequestBody CandidateSchoolDto candidateSchool) {

		return this.candidateSchoolService.updateSchool(candidateSchool);

	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolDto school) {

		return this.candidateSchoolService.add(school);

	}

	@GetMapping("/getall")
	public DataResult<List<CandidateSchool>> getAll() {

		return this.candidateSchoolService.getAll();

	}

	@GetMapping("/getcandidateschoolswithordered")
	public DataResult<List<CandidateSchool>> orderedCandidateCvSchools(@RequestParam int id) {

		return this.candidateSchoolService.orderedCandidateCvSchools(id);

	}

}
