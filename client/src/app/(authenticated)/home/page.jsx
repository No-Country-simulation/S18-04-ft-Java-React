import { HomeArticles } from '@/components/sections/HomeArticles/HomeArticles';
import { HomeCountdownSection } from '@/components/sections/HomeCountdownSection/HomeCountdownSection';
import { HomeMain } from '@/components/sections/HomeMain/HomeMain';
import { HomeWidget } from '@/components/sections/HomeWidget/HomeWidget';

export default function HomePage() {
  return (
    <>
      <HomeMain name="Marcos" />
      <HomeWidget />
      <HomeCountdownSection />
      <HomeArticles />
    </>
  );
}
