'use client';
import { useEffect } from 'react';
import { getTeam } from '@/components/MyTeam/action';
import { MyTeam } from '@/components/MyTeam/MyTeam';

export default function MyTeamIdPage(params) {
  let id = params.id;

  // useEffect(() => {
  //   getTeam(id);
  // }, [])

  return <MyTeam />;
}
