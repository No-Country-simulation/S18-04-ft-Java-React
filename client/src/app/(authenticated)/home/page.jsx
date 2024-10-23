import { HomeArticles } from '@/components/sections/HomeArticles/HomeArticles';
import { HomeCountdownSection } from '@/components/sections/HomeCountdownSection/HomeCountdownSection';
import { HomeMain } from '@/components/sections/HomeMain/HomeMain';
import { HomeWidget } from '@/components/sections/HomeWidget/HomeWidget';

async function logPageView(token) {
  const baseUrl = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:3000';
  const apiUrl = `${baseUrl}/api/check`;
  fetch(apiUrl, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json', TOKEN: token },
  });
}

export default async function HomePage({ searchParams }) {
  const token = (await searchParams)?.token;
  if (token) {
    await logPageView(token);
  }
  return (
    <>
      <HomeMain name="Marcos" token={token} />
      <HomeWidget />
      <HomeCountdownSection />
      <HomeArticles />
    </>
  );
}
