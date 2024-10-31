import { MyTeam } from '@/components/MyTeam/MyTeam';

export default function MyTeamIdPage({ params }) {
  let id = params.id;

  return <MyTeam teamId={id} />;
}
