import { cookies } from 'next/headers';
import { NextResponse } from 'next/server';

export const maxDuration = 30;

export async function GET(req) {
  const cookieStore = cookies();
  cookieStore.delete('token');
  cookieStore.delete('USER');
  return NextResponse.json({ response: 'Checkin' }, { status: 200 });
}
