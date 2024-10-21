import { AuthFooter } from '@/components/AuthFooter/AuthFooter';
import { AuthHeader } from '@/components/AuthHeader/AuthHeader';

export default function LayoutAuthenticated({ children }) {
  return (
    <>
      <AuthHeader />
      {children}
      <AuthFooter />
    </>
  );
}
