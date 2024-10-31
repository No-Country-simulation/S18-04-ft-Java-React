import React from 'react';
import { MyTeamCard } from '../Card/MyTeamCard';
import { Meeting } from '../Meeting/Meeting';
import { getMyTeam } from '@/data/getMyTeam';

export const MyTeam = async ({ teamId }) => {
  const data = await getMyTeam(teamId);

  return (
    <>
      <div className="mx-auto mb-5 mt-8 w-full max-w-[90%] leading-[14px] text-white">
        <div
          className="flex h-9 w-full items-center justify-center rounded-md bg-[#063963] p-5 text-xl font-medium"
          aria-label="Team">
          {data[0]?.teamName}
        </div>
        {data.map((profile, index) => (
          <MyTeamCard
            key={index}
            name={profile.profileName}
            rol={profile.roleType?.roleTypeName}
            tl={profile.tl}
          />
        ))}
      </div>
      <Meeting />
    </>
  );
};
