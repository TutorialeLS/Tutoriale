package pl.javastart.weekop.dao;

import pl.javastart.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {

	public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId);
}