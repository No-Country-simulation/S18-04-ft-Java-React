import { setCookie } from 'cookies-next';
import { cookies } from 'next/headers';
import { NextResponse } from 'next/server';
import { getCurrentToken } from '@/data/auth';

export const maxDuration = 30;

export async function GET(req) {
  const token = req.headers.get('TOKEN');
  const currentToken = getCurrentToken();
  if (!currentToken) {
    cookies().set('token', token, {
      httpOnly: false,
      secure: true,
      path: '/',
      maxAge: 60 * 60 * 24 * 7,
    });
  }

  return NextResponse.json({ response: 'Checkin' }, { status: 200 });
}
