import React from 'react';
import { MyTeamCard } from '../Card/MyTeamCard';
import { Meeting } from '../Meeting/Meeting';

export const MyTeam = () => {
  return (
    <>
      <div className="mx-auto mb-5 mt-8 w-full max-w-[90%] leading-[14px] text-white">
        <div
          className="flex h-9 w-full items-center justify-center rounded-md bg-[#063963] p-5 text-xl font-medium"
          aria-label="Team">
          S18-04-ft-Java-React
        </div>
        <MyTeamCard name="Ramiro Brites" rol="UX/UI" tl={false} />
        <MyTeamCard name="Sofia Gonzales" rol="FrontEnd" tl={false} />
        <MyTeamCard name="Maria Escobar" rol="FrontEnd" tl={false} />
        <MyTeamCard name="Gonzalo Aguirre" rol="BackEnd" tl={false} />
        <MyTeamCard name="Oscar Perez" rol="BackEnd" tl={false} />
        <MyTeamCard name="Julio Escobar" rol="Tester QA" tl={false} />
        <MyTeamCard name="Victoria Molina" rol="Team Leader" tl={true} />
      </div>
      <Meeting />
    </>
  );
};
