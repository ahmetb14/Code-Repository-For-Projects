package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<Candidate> add(Candidate candidate);

	DataResult<List<Candidate>> getAll();

}
