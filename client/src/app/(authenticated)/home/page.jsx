import { HomeArticles } from '@/components/sections/HomeArticles/HomeArticles';
import { HomeCountdownSection } from '@/components/sections/HomeCountdownSection/HomeCountdownSection';
import { HomeMain } from '@/components/sections/HomeMain/HomeMain';
import { HomeWidget } from '@/components/sections/HomeWidget/HomeWidget';

export default function HomePage() {
  return (
    <div className="no-bg-gradient mx-auto mb-5 flex size-full max-w-3xl flex-1 flex-col">
      <HomeMain name="Marcos" />
      <HomeWidget />
      <HomeCountdownSection />
      <HomeArticles />
    </div>
  );
}
