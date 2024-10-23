import { HomeArticles } from '@/components/sections/HomeArticles/HomeArticles';
import { HomeCountdownSection } from '@/components/sections/HomeCountdownSection/HomeCountdownSection';
import { HomeMain } from '@/components/sections/HomeMain/HomeMain';
import { HomeWidget } from '@/components/sections/HomeWidget/HomeWidget';
import { cookies } from 'next/headers';

async function logPageView(token) {
  'use server';

  cookies().set('token', token, {
    httpOnly: false,
    secure: true,
    path: '/',
    maxAge: 60 * 60 * 24 * 7,
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
