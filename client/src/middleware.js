export function middleware(request) {
  const token = request.cookies.get('token')?.value;
  console.log("---------------------------------------------------------");
  console.log({ cookiess:request.cookies });
  console.log({ cookie:request.cookies.get('token') });
  console.log({ token });
  console.log("---------------------------------------------------------");
  if (token && request.nextUrl.pathname.startsWith('/signin')) {
    return Response.redirect(new URL('/', request.url));
  }
}

export const config = {
  matcher: ['/((?!api|_next/static|_next/image|.*\\.png$).*)'],
};
