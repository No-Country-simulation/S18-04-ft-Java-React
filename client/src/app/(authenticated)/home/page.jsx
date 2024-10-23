import { HomeArticles } from '@/components/sections/HomeArticles/HomeArticles';
import { HomeCountdownSection } from '@/components/sections/HomeCountdownSection/HomeCountdownSection';
import { HomeMain } from '@/components/sections/HomeMain/HomeMain';
import { HomeWidget } from '@/components/sections/HomeWidget/HomeWidget';

export default async function HomePage({ searchParams }) {
  const token = (await searchParams)?.token;
  return (
    <>
      <HomeMain name="Marcos" token={token} />
      <HomeWidget />
      <HomeCountdownSection />
      <HomeArticles />
    </>
  );
}
