package org.springframework.cloud.heroku;

import org.springframework.cloud.service.common.PostgresqlServiceInfo;

/**
 *
 * @author Ramnivas Laddad
 *
 */
public class PostgresqlServiceInfoCreator extends RelationalServiceInfoCreator<PostgresqlServiceInfo> {

	public PostgresqlServiceInfoCreator() {
		super(PostgresqlServiceInfo.POSTGRES_SCHEME);
	}

	@Override
	public PostgresqlServiceInfo createServiceInfo(String id, String uri) {
		return new PostgresqlServiceInfo(HerokuUtil.computeServiceName(id), uri);
	}

	@Override
	public String[] getEnvPrefixes() {
		return new String[]{"DATABASE_URL", "HEROKU_POSTGRESQL_"};
	}
}
